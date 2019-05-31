package intro.to.antlr;

public enum CupSize {
    SHOT,
    SHORT,
    TALL,
    GRANDE;
    
    @Override
    public String toString() {
        return this.name() + "_CUP";
    }
}
