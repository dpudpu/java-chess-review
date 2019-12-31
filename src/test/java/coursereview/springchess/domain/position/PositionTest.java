package coursereview.springchess.domain.position;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PositionTest {

    @Test
    void 가로인지_확인() {
        assertThat(Position.A1.isRow(Position.A2)).isTrue();
        assertThat(Position.A1.isRow(Position.A8)).isTrue();
        assertThat(Position.B1.isRow(Position.B2)).isTrue();

        assertThat(Position.A1.isRow(Position.B1)).isFalse();
        assertThat(Position.A1.isRow(Position.B2)).isFalse();
        assertThat(Position.A1.isRow(Position.C3)).isFalse();
    }

    @Test
    void 세로인지_확인() {
        assertThat(Position.A1.isColumn(Position.B1)).isTrue();
        assertThat(Position.A1.isColumn(Position.C1)).isTrue();
        assertThat(Position.A1.isColumn(Position.H1)).isTrue();

        assertThat(Position.A1.isColumn(Position.A2)).isFalse();
        assertThat(Position.A1.isColumn(Position.B2)).isFalse();
        assertThat(Position.A1.isColumn(Position.C3)).isFalse();
    }

    @Test
    void 대각선_인지_확인() {
        assertThat(Position.C3.isDiagonal(Position.A5)).isTrue();
        assertThat(Position.A5.isDiagonal(Position.C3)).isTrue();
        assertThat(Position.C3.isDiagonal(Position.A1)).isTrue();
        assertThat(Position.A1.isDiagonal(Position.C3)).isTrue();

        assertThat(Position.C3.isDiagonal(Position.C2)).isFalse();
        assertThat(Position.C3.isDiagonal(Position.B3)).isFalse();
    }

    @Test
    void change() {
        final Position expected = Position.B3;
        final Position actual = Position.A1.change(1, 2);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("존재하지 않는 위치로 이동을 시도할 경우 예외가 발생한다.")
    void changeException() {
        assertThrows(IllegalStateException.class, () -> Position.A1.change(-1, -1));
    }
}