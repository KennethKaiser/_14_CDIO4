package dtu.board;

public class TaxField extends Field{

    private Tax tax;


    public TaxField(Tax tax) {
        this.tax = tax;
    }

    @Override
    public String landedLabel() {
        return "Du er landet på " + tax.getName()+".";
    }

    @Override
    public String type() {
        return "tax";
    }

    public Tax getTax() {
        return tax;
    }
}
