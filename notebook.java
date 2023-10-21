public class notebook {
    private String memory;
    private String hdd;
    private String os;
    private String colour;

    public notebook(String memory, String hdd, String os, String colour) {
        this.memory = memory;
        this.hdd = hdd;
        this.os = os;
        this.colour = colour;
    }

    public String getMemory() {
        return memory;
    }

    public String getHdd() {
        return hdd;
    }

    public String getOs() {
        return os;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return "notebook [memory=" + memory + ", hdd=" + hdd + ", os=" + os + ", colour=" + colour + "] \n";
    }
}
