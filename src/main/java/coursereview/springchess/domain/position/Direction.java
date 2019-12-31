package coursereview.springchess.domain.position;

public enum Direction {
    N(0, 1),
    NE(1, 1),
    NW(-1, 1),
    S(0, -1),
    SE(1, -1),
    SW(-1, -1),
    E(1, 0),
    W(-1, 0),

    NNE(1, 2),
    NNW(-1, 2),
    NEE(2, 1),
    NWW(-2, 1),
    SSE(1, -2),
    SSW(-1, -2),
    SEE(2, -1),
    SWW(-2, -1);

    private final int x;
    private final int y;

    Direction(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public Position move(final Position source) {
        return source.change(x, y);
    }
}
