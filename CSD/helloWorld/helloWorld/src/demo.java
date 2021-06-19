public class demo {
    int a;

    public demo() {
    }

    public demo(int a) {
        this.a = a;
    }

    public int getA() {
        return this.a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public demo a(int a) {
        setA(a);
        return this;
    }

    // @Override
    // public boolean equals(Object o) {
    //     if (o == this)
    //         return true;
    //     if (!(o instanceof demo)) {
    //         return false;
    //     }
    //     demo demo = (demo) o;
    //     return a == demo.a;
    // }

    // @Override
    // public int hashCode() {
    //     return Objects.hashCode(a);
    // }

    @Override
    public String toString() {
        return "{" +
            " a='" + getA() + "'" +
            "}";
    }
    
}
