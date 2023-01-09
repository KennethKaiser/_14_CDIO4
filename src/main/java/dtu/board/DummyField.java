package dtu.board;

public class DummyField extends Field{

    private Dummy dummy;

    public DummyField(Dummy dummy) {
        this.dummy = dummy;
    }

    @Override
    public String landedLabel() {
        return "Du er landet på " + dummy.getName()+".";
    }

    @Override
    public String type() {
        return "dummy";
    }

    public Dummy getDummy() {
        return dummy;
    }
}
