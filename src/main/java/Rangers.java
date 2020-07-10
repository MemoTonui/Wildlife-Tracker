import java.util.Objects;

public class Rangers {

    private  String email;
    private  String name;


    public Rangers(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    //Checks if two names and their email addresses are similar
    @Override
    public boolean equals(Object ranger2){
        if (!(ranger2 instanceof Rangers)) {
            return false;
        } else {
            Rangers newRanger = (Rangers) ranger2;
            return this.getName().equals(newRanger.getName()) &&
                    this.getEmail().equals(newRanger.getEmail());
        }
    }

}
