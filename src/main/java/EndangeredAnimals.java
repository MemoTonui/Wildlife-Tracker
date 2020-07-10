public class EndangeredAnimals extends Animals {

  /*  public static final String ILL="Ill";
    public static final String HEALTHY="Healthy";
    public static final String OKAY="Okay";
    public static final String NEW_BORN= "newborn";
    public static final String YOUNG= "young";
    public static final String ADULT = "adult";*/
    private String age;
    private String health;
    private int id;

    public EndangeredAnimals(String animalName,int rangerId,String age,String health) {
        super(animalName,rangerId);
       /* if (animalName == ""||age==""||health==""){
            throw new UnsupportedOperationException("Please Fill in all Blanks");
        }
        else {*/
            this.animalName = animalName;
            this.rangerId = rangerId;
            this.age = age;
            this.health = health;

    }


    public String getAge() {
        return age;
    }

    public String getHealth() {
        return health;
    }

    @Override
    public int getId() {
        return id;
    }




}
