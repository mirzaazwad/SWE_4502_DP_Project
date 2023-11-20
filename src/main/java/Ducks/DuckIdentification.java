package Ducks;

public class DuckIdentification {
    protected static Integer ID=1;
    private Integer _id;
    public DuckIdentification(){
        this._id=ID;
        ID+=1;
    }

    public String getID(){
        return this._id.toString();
    }

}
