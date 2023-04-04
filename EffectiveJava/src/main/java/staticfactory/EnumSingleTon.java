package staticfactory;

public enum EnumSingleTon {
    INSTANCE;

    public void leaveTheBuilding(){
        System.out.println("기다려");

    }

    public static void main(String[] args) {
        EnumSingleTon enumSingleTon = EnumSingleTon.INSTANCE;
        enumSingleTon.leaveTheBuilding();
    }

}
