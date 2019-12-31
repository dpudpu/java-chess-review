package coursereview.springchess.domain.position;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @ParameterizedTest
    @MethodSource("provide")
    void 이동_테스트(final Direction direction, final Position expected) {
        final Position actual = direction.move(Position.C4);

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> provide() {
        return Stream.of(
                Arguments.of(Direction.N, Position.C5),
                Arguments.of(Direction.NE, Position.D5),
                Arguments.of(Direction.NW, Position.B5),
                Arguments.of(Direction.S, Position.C3),
                Arguments.of(Direction.SE, Position.D3),
                Arguments.of(Direction.SW, Position.B3),
                Arguments.of(Direction.E, Position.D4),
                Arguments.of(Direction.W, Position.B4),
                Arguments.of(Direction.NNE, Position.D6),
                Arguments.of(Direction.NNW, Position.B6),
                Arguments.of(Direction.NEE, Position.E5),
                Arguments.of(Direction.NWW, Position.A5),
                Arguments.of(Direction.SEE, Position.E3),
                Arguments.of(Direction.SSE, Position.D2),
                Arguments.of(Direction.SWW, Position.A3),
                Arguments.of(Direction.SSW, Position.B2)
        );
    }
}