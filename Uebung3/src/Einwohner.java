public class Einwohner{

    protected int einkommen;

    void setEinkommen(int einkommen){
        this.einkommen = einkommen;
    }

    int zuVersteuerndesEinkommen(){
        return einkommen - 10;
    }

    int steuer(){
        return (int)(einkommen * 0.2);
    }
}

class Koenig extends Einwohner{
    protected int einkommen;
    void setEinkommen(int einkommen){
        this.einkommen = einkommen;
    }

    int zuVersteuerndesEinkommen(){
        return einkommen - 10;
    }

    int steuer(){
        return (int)(einkommen * 0.2);
    }

}

class Adel extends Einwohner{
    protected int einkommen;
    void setEinkommen(int einkommen){
        this.einkommen = einkommen;
    }

    int zuVersteuerndesEinkommen(){
        return einkommen - 10;
    }

    int steuer(){
        return (int)(einkommen * 0.2);
    }
}

class Bauer extends Einwohner{


    int zuVersteuerndesEinkommen(){
        return einkommen - 10;
    }

    int steuer(){
        return (int)(einkommen * 0.2);
    }
}

class Leibeigener extends Einwohner{
    protected int einkommen;
    void setEinkommen(int einkommen){
        this.einkommen = einkommen;
    }

    int zuVersteuerndesEinkommen(){
        return einkommen - 10;
    }

    int steuer(){
        return (int)(einkommen * 0.2);
    }
}
