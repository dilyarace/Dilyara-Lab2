package proxy_design_pattern;

interface DatabaseExecuter {
    public void executeDatabase(String query) throws Exception;
}

// The concrete implementation of the DatabaseExecuter interface.
class DatabaseExecuterImpl implements DatabaseExecuter {
    @Override
    public void executeDatabase(String query) throws Exception {
        System.out.println("Going to execute Query: " + query);
    }
}

// The proxy class for executing database queries.
class DatabaseExecuterProxy implements DatabaseExecuter {
    boolean ifAdmin;
    DatabaseExecuterImpl dbExecuter;

    public DatabaseExecuterProxy(String name, String passwd) {
        if (name.equals("Admin") && passwd.equals("Admin@123")) {
            ifAdmin = true;
        }
        dbExecuter = new DatabaseExecuterImpl();
    }

    @Override
    public void executeDatabase(String query) throws Exception {
        if (ifAdmin) {
            dbExecuter.executeDatabase(query);
        } else {
            if (query.equals("DELETE")) {
                throw new Exception("DELETE not allowed for non-admin user");
            } else {
                dbExecuter.executeDatabase(query);
            }
        }
    }
}

public class ProxyPattern {
    public static void main(String[] args) throws Exception {
        // Create a non-admin proxy with invalid query (DELEE).
        DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
        nonAdminExecuter.executeDatabase("DELEE"); // Should work with valid queries but not with "DELETE".

        // Create another non-admin proxy with an attempt to execute a "DELETE" query.
        DatabaseExecuter nonAdminExecuterDELETE = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
        nonAdminExecuterDELETE.executeDatabase("DELETE"); // Should throw an exception.

        // Create an admin proxy and execute a "DELETE" query.
        DatabaseExecuter adminExecuter = new DatabaseExecuterProxy("Admin", "Admin@123");
        adminExecuter.executeDatabase("DELETE"); // Should work for admin user.
    }
}
