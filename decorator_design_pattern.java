package decorator_design_pattern;

// Interface defining the basic functionality of dressing
interface Dress {
    public void assemble();
}

// Concrete class implementing the basic dress features
class BasicDress implements Dress {
    @Override
    public void assemble() {
        System.out.println("Basic Dress Features");
    }
}

// DressDecorator class that extends Dress and acts as the base decorator
class DressDecorator implements Dress {
    protected Dress dress;

    public DressDecorator(Dress c) {
        this.dress = c;
    }

    @Override
    public void assemble() {
        this.dress.assemble();
    }
}

// Concrete decorator for adding casual dress features
class CasualDress extends DressDecorator {
    public CasualDress(Dress c) {
        super(c);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Casual Dress Features");
    }
}

// Concrete decorator for adding sporty dress features
class SportyDress extends DressDecorator {
    public SportyDress(Dress c) {
        super(c);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Sporty Dress Features");
    }
}

// Concrete decorator for adding fancy dress features
class FancyDress extends DressDecorator {
    public FancyDress(Dress c) {
        super(c);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Fancy Dress Features");
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        // Create a SportyDress that decorates a BasicDress
        Dress sportyDress = new SportyDress(new BasicDress());
        sportyDress.assemble();
        System.out.println();

        // Create a FancyDress that decorates a BasicDress
        Dress fancyDress = new FancyDress(new BasicDress());
        fancyDress.assemble();
        System.out.println();

        // Create a CasualDress that decorates a BasicDress
        Dress casualDress = new CasualDress(new BasicDress());
        casualDress.assemble();
        System.out.println();

        // Create a SportyDress that decorates a FancyDress, which decorates a BasicDress
        Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
        sportyFancyDress.assemble();
        System.out.println();

        // Create a CasualDress that decorates a FancyDress, which decorates a BasicDress
        Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
        casualFancyDress.assemble();
    }
}
