public abstract class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


    public void showInfo() {
        System.out.println("[유저 정보] 이름: " + name);
    }
}