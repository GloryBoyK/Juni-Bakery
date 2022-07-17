import java.util.*;

public class Bakery {
  private String name;
  private String address;
  private ArrayList<BakedGood> bakedGoods = new ArrayList<>();
  private ArrayList<Worker> workers = new ArrayList<>();

  public Bakery(String n, String a) {
    name = n;
    address = a;
  }

  // NESTED BAKEDGOODS CLASS 
  private final class BakedGood {
    private String name;
    private String[] ingredients;
    private int numIngredients;
    private String flavour;
    private int batchSize;

    public BakedGood(String n, String[] i, int ni, String f, int b) {
    name = n;
    ingredients = i;
    numIngredients = ni;
    flavour = f;
    batchSize = b;
    }

    public String getFlavour() {
    return flavour;
    }

    public int getNumIngredients() {
      return numIngredients;
    }

    public void setBatchSize(int b) {
      batchSize = b;
    }

    private String returnIngredients() {
      String ingredientsList = "";

      for (int i = 0; i < numIngredients; i++) {
        if (i < numIngredients - 1) {
          ingredientsList += ingredients[i] + ", ";
        } else {
          ingredientsList += ingredients[i];
        }
      }
      return ingredientsList;
    }

    public String toString() {
      return name + "\n\tFlavour: " + flavour + "\n\tIngredients: " + returnIngredients();
    }
  }

  // NESTED WORKER CLASS 
  private final class Worker {
    private String name;
    private String position;
    private boolean employeeOfTheMonth;
    private double salary;

    public Worker(String n, String p, boolean e, double s) {
      name = n;
      position = p;
      employeeOfTheMonth = e;
      salary = s;
    }

    public String getName() {
      return name;
    }

    public double getSalary() {
      return salary;
    } 

    public void giveRaise(double raiseIncrease) {
      salary += raiseIncrease;
    }

    public boolean isEmployeeOfTheMonth() {
      return employeeOfTheMonth;
    }

    public void makeEmployeeOfTheMonth() {
      employeeOfTheMonth = true;
    }

    public String getPosition(){
      return position;
    }

    public void changePosition(String p){
      position = p;
    }

    public String toString() {
      String s = "Name: " + name + "\n\tPosition: " + position + "\n\tSalary: $" + String.format("%.2f", salary) + " per hour";

      if (employeeOfTheMonth) {
        s += "\n\tEmployee of the Month";
      }

      return s; 
    }
  }

  //PROVIDED METHODS 
  public String getName() {
    return name;
  }
  public String getAddress() {
    return address;
  }
  public int getNumWorkers() {
    return workers.size();
  }

  //BAKERY METHODS 
  
  /**
  * creates the given number of Worker objects and adds them to the workers ArrayList
  * @param numWorkers - the number of Worker objects to create
  **/
  public void hireWorkers(int numWorkers) {
    //TODO
    
    Scanner s = new Scanner(System.in);
    
    for(int i=0; i<numWorkers; i++){
      System.out.println("Enter worker number "+(i+1)+" name.");
      String name=s.nextLine();
      System.out.println("Enter worker number "+(i+1)+" position.");
      String position=s.nextLine();
      System.out.println("Enter worker number "+(i+1)+" salary.");
      double salary=s.nextDouble();
      System.out.println("Is worker "+(i+1)+" employee of the month (Y/N).");
      String eofm=s.nextLine();
      boolean employeeOfTheMonth=false;
      if(eofm.equals("Y")){
        employeeOfTheMonth=true;
      }
      Worker w=new Worker(name, position, employeeOfTheMonth, salary);
      workers.add(w);
      System.out.println();
    }
    
  }
  /**
  * creates the given number of BakedGood objects and adds them to the bakedGoods ArrayList
  * @param numBakedGoods - the number of BakedGood objects to create
  **/
  public void addBakedGoods(int numBakedGoods) {
    //private String name;
    //private String[] ingredients;
    //private int numIngredients;
    //private String flavour;
    //private int batchSize;
    Scanner s=new Scanner(System.in);
    //TODO HW
    for(int i=0; i<numBakedGoods; i++){
      System.out.println("Enter baked good's "+(i+1)+"name");
      String name=s.nextLine();
      System.out.println("Enter number of ingredients in "+(i+1)+"baked good");
      int numIngredients=s.nextInt();
      String[] ingredients=new String[numIngredients];
      for(int j=0; j<numIngredients; j++){
        System.out.println("What is the next ingredient in the baked good?");
        String ingredient=s.nextLine();
        ingredients[j]=ingredient;
        
        //finish all ingredients for HW
        
      }
      System.out.println("Enter baked good's "+(i+1)+"flavour");
      String flavour=s.nextLine();
      System.out.println("Enter baked good's "+(i+1)+"batch size");
      int batchSize=s.nextInt();
      BakedGood b=new BakedGood(name, ingredients, numIngredients, flavour, batchSize);
      bakedGoods.add(b);
      System.out.println();
      
    }
  }
  public String toString() {
    
    return "Welcome to the bakery, we have "+workers.size()+" workers, here is our employee roster:"+employeeRoster();
  }
  
  public String employeeRoster(){
    String roster="";
    for(int i=0; i<workers.size(); i++){
      roster="\n"+workers.get(i).toString()+"\n";
    }
    return roster;
  }
}