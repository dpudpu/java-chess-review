package coursereview.springchess.domain.piece.rule;

import coursereview.springchess.domain.position.Position;

import java.util.List;

public interface Rule {

    boolean canMove(final Position source, final Position target);

    List<Position> findMovablePositions(final Position source);

    default boolean canAttack(final Position source, final Position target) {
        return canMove(source, target);
    }

    int getScore();
}
