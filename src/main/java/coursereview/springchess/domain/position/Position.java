package coursereview.springchess.domain.position;

import java.util.HashMap;
import java.util.Map;

public enum Position {
    A1('a', 1), A2('a', 2), A3('a', 3), A4('a', 4), A5('a', 5), A6('a', 6), A7('a', 7), A8('a', 8),
    B1('b', 1), B2('b', 2), B3('b', 3), B4('b', 4), B5('b', 5), B6('b', 6), B7('b', 7), B8('b', 8),
    C1('c', 1), C2('c', 2), C3('c', 3), C4('c', 4), C5('c', 5), C6('c', 6), C7('c', 7), C8('c', 8),
    D1('d', 1), D2('d', 2), D3('d', 3), D4('d', 4), D5('d', 5), D6('d', 6), D7('d', 7), D8('d', 8),
    E1('e', 1), E2('e', 2), E3('e', 3), E4('e', 4), E5('e', 5), E6('e', 6), E7('e', 7), E8('e', 8),
    F1('f', 1), F2('f', 2), F3('f', 3), F4('f', 4), F5('f', 5), F6('f', 6), F7('f', 7), F8('f', 8),
    G1('g', 1), G2('g', 2), G3('g', 3), G4('g', 4), G5('g', 5), G6('g', 6), G7('g', 7), G8('g', 8),
    H1('h', 1), H2('h', 2), H3('h', 3), H4('h', 4), H5('h', 5), H6('h', 6), H7('h', 7), H8('h', 8);

    private static final int DIAGONAL_INCLINATION = 1;

    private final int x;
    private final int y;

    Position(final char x, final int y) {
        this.x = x;
        this.y = y;
    }

    public Position change(final int x, final int y) {
        final int newX = this.x + x;
        final int newY = this.y + y;
        final String key = String.valueOf((char) newX) + newY;
        return PositionMap.get(key);
    }

    public boolean isRow(final Position other) {
        return this.x == other.x;
    }

    public boolean isColumn(final Position other) {
        return this.y == other.y;
    }

    public boolean isDiagonal(final Position other) {
        int width = Math.abs(this.x) - Math.abs(other.x);
        int height = Math.abs(this.y) - Math.abs(other.y);

        if (height == 0) {
            return false;
        }
        return Math.abs(width / height) == DIAGONAL_INCLINATION;
    }

    private static class PositionMap {
        public static final Map<String, Position> map = new HashMap<>();

        static {
            for (final Position value : Position.values()) {
                final String key = value.toString().toLowerCase();
                map.put(key, value);
            }
        }

        public static Position get(final String key) {
            if (map.containsKey(key)) {
                return map.get(key);
            }
            throw new IllegalStateException("존재하지 않는 위치로 이동을 시도했습니다.");
        }
    }
}
