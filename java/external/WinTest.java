package external;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import base.Start;
import base.TerminalMock;
import edu.kit.informatik.Terminal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * WinTest
 *
 * @author Valentin Wagner
 * 10.02.18
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Terminal.class)
class WinTest {

    private TerminalMock terminalMock;

    public WinTest() {
    }

    @Before
    public void init() {
        this.terminalMock = new TerminalMock();
    }


    @Test
    public void testWinStandardRow() throws Exception {
        terminalMock.mock()
                .willReturn("place 0;0;0;1")
                .willReturn("place 5;4;3;2")
                .willReturn("place 0;2;0;3")
                .willReturn("place 9;7;6;4")
                .willReturn("place 0;4;0;5")
                .willReturn("quit");

        Start.game("standard", "18", "2");

        assertThat(terminalMock.isError()).isFalse();
        assertThat(terminalMock.getCaptor().getValue()).isEqualTo("P1 wins");
    }

    @Test
    public void testWinTorusRow() throws Exception {
        terminalMock.mock()
                .willReturn("place 0;0;0;1")
                .willReturn("place 5;4;3;2")
                .willReturn("place 0;2;0;3")
                .willReturn("place 9;7;6;4")
                .willReturn("place 0;-1;0;-2")
                .willReturn("quit");

        Start.game("torus", "18", "2");

        assertThat(terminalMock.isError()).isFalse();
        assertThat(terminalMock.getCaptor().getValue()).isEqualTo("P1 wins");
    }

    @Test
    public void testWinStandardColumn() throws Exception {
        terminalMock.mock()
                .willReturn("place 0;0;1;0")
                .willReturn("place 0;1;1;1")
                .willReturn("place 2;0;3;0")
                .willReturn("place 2;1;3;1")
                .willReturn("place 4;0;5;0")
                .willReturn("quit");

        Start.game("standard", "18", "2");

        assertThat(terminalMock.isError()).isFalse();
        assertThat(terminalMock.getCaptor().getValue()).isEqualTo("P1 wins");
    }

    @Test
    public void testWinTorusColumn() throws Exception {
        terminalMock.mock()
                .willReturn("place 0;0;1;0")
                .willReturn("place 0;1;1;1")
                .willReturn("place 2;0;3;0")
                .willReturn("place 2;1;3;1")
                .willReturn("place -1;0;-2;0")
                .willReturn("quit");

        Start.game("torus", "18", "2");

        assertThat(terminalMock.isError()).isFalse();
        assertThat(terminalMock.getCaptor().getValue()).isEqualTo("P1 wins");
    }

    @Test
    public void testWinStandartDiagonalLeftToRight() throws Exception {
        terminalMock.mock()
                .willReturn("place 0;0;1;1")
                .willReturn("place 5;6;4;5")
                .willReturn("place 2;2;3;3")
                .willReturn("place 8;7;6;5")
                .willReturn("place 4;4;5;5")
                .willReturn("quit");

        Start.game("standard", "18", "2");

        assertThat(terminalMock.isError()).isFalse();
        assertThat(terminalMock.getCaptor().getValue()).isEqualTo("P1 wins");
    }

    @Test
    public void testWinTorusDiagonalLeftToRight() throws Exception {
        terminalMock.mock()
                .willReturn("place 0;0;1;1")
                .willReturn("place 5;6;4;5")
                .willReturn("place 2;2;3;3")
                .willReturn("place 8;7;6;5")
                .willReturn("place -1;-1;-2;-2")
                .willReturn("quit");

        Start.game("torus", "18", "2");

        assertThat(terminalMock.isError()).isFalse();
        assertThat(terminalMock.getCaptor().getValue()).isEqualTo("P1 wins");
    }

    @Test
    public void testWinStandartDiagonalRightToLeft() throws Exception {
        terminalMock.mock()
                .willReturn("place 17;17;16;16")
                .willReturn("place 5;6;4;5")
                .willReturn("place 15;15;14;14")
                .willReturn("place 8;7;6;5")
                .willReturn("place 13;13;12;12")
                .willReturn("quit");

        Start.game("standard", "18", "2");

        assertThat(terminalMock.isError()).isFalse();
        assertThat(terminalMock.getCaptor().getValue()).isEqualTo("P1 wins");
    }

    @Test
    public void testWinTorusDiagonalRightToLeft() throws Exception {
        terminalMock.mock()
                .willReturn("place 17;17;16;16")
                .willReturn("place 5;6;4;5")
                .willReturn("place 15;15;14;14")
                .willReturn("place 8;7;6;5")
                .willReturn("place 18;18;19;19")
                .willReturn("quit");

        Start.game("torus", "18", "2");

        assertThat(terminalMock.isError()).isFalse();
        assertThat(terminalMock.getCaptor().getValue()).isEqualTo("P1 wins");
    }

    @Test
    public void testDraw2() throws Exception {
        terminalMock.mock()
                .willReturn("place 0;0;0;2")
                .willReturn("place 0;1;0;3")
                .willReturn("place 0;4;0;6")
                .willReturn("place 0;5;0;7")
                .willReturn("place 0;8;0;10")
                .willReturn("place 0;9;0;11")
                .willReturn("place 0;12;0;14")
                .willReturn("place 0;13;0;15")
                .willReturn("place 0;16;1;0")
                .willReturn("place 0;17;1;1")
                .willReturn("place 1;2;1;4")
                .willReturn("place 1;3;1;5")
                .willReturn("place 1;6;1;8")
                .willReturn("place 1;7;1;9")
                .willReturn("place 1;10;1;12")
                .willReturn("place 1;11;1;13")
                .willReturn("place 1;14;1;16")
                .willReturn("place 1;15;1;17")
                .willReturn("place 2;0;2;2")
                .willReturn("place 2;1;2;3")
                .willReturn("place 2;4;2;6")
                .willReturn("place 2;5;2;7")
                .willReturn("place 2;8;2;10")
                .willReturn("place 2;9;2;11")
                .willReturn("place 2;12;2;14")
                .willReturn("place 2;13;2;15")
                .willReturn("place 2;16;3;0")
                .willReturn("place 2;17;3;1")
                .willReturn("place 3;2;3;4")
                .willReturn("place 3;3;3;5")
                .willReturn("place 3;6;3;8")
                .willReturn("place 3;7;3;9")
                .willReturn("place 3;10;3;12")
                .willReturn("place 3;11;3;13")
                .willReturn("place 3;14;3;16")
                .willReturn("place 3;15;3;17")
                .willReturn("place 7;15;7;17")
                .willReturn("place 4;0;4;2")
                .willReturn("place 4;1;4;3")
                .willReturn("place 4;4;4;6")
                .willReturn("place 4;5;4;7")
                .willReturn("place 4;8;4;10")
                .willReturn("place 4;9;4;11")
                .willReturn("place 4;12;4;14")
                .willReturn("place 4;13;4;15")
                .willReturn("place 4;16;5;0")
                .willReturn("place 4;17;5;1")
                .willReturn("place 5;2;5;4")
                .willReturn("place 5;3;5;5")
                .willReturn("place 5;6;5;8")
                .willReturn("place 5;7;5;9")
                .willReturn("place 5;10;5;12")
                .willReturn("place 5;11;5;13")
                .willReturn("place 5;14;5;16")
                .willReturn("place 5;15;5;17")
                .willReturn("place 6;0;6;2")
                .willReturn("place 6;1;6;3")
                .willReturn("place 6;4;6;6")
                .willReturn("place 6;5;6;7")
                .willReturn("place 6;8;6;10")
                .willReturn("place 6;9;6;11")
                .willReturn("place 6;12;6;14")
                .willReturn("place 6;13;6;15")
                .willReturn("place 6;16;7;0")
                .willReturn("place 6;17;7;1")
                .willReturn("place 7;2;7;4")
                .willReturn("place 7;3;7;5")
                .willReturn("place 7;6;7;8")
                .willReturn("place 7;7;7;9")
                .willReturn("place 7;10;7;12")
                .willReturn("place 7;11;7;13")
                .willReturn("place 7;14;7;16")
                .willReturn("place 8;0;8;2")
                .willReturn("place 8;1;8;3")
                .willReturn("place 8;4;8;6")
                .willReturn("place 8;5;8;7")
                .willReturn("place 8;8;8;10")
                .willReturn("place 8;9;8;11")
                .willReturn("place 8;12;8;14")
                .willReturn("place 8;13;8;15")
                .willReturn("place 8;16;9;0")
                .willReturn("place 8;17;9;1")
                .willReturn("place 9;2;9;4")
                .willReturn("place 9;3;9;5")
                .willReturn("place 9;6;9;8")
                .willReturn("place 9;7;9;9")
                .willReturn("place 9;10;9;12")
                .willReturn("place 9;11;9;13")
                .willReturn("place 9;14;9;16")
                .willReturn("place 9;15;9;17")
                .willReturn("place 10;0;10;2")
                .willReturn("place 10;1;10;3")
                .willReturn("place 10;4;10;6")
                .willReturn("place 10;5;10;7")
                .willReturn("place 10;8;10;10")
                .willReturn("place 10;9;10;11")
                .willReturn("place 10;12;10;14")
                .willReturn("place 10;13;10;15")
                .willReturn("place 10;16;11;0")
                .willReturn("place 10;17;11;1")
                .willReturn("place 11;2;11;4")
                .willReturn("place 11;3;11;5")
                .willReturn("place 11;6;11;8")
                .willReturn("place 11;7;11;9")
                .willReturn("place 11;10;11;12")
                .willReturn("place 11;11;11;13")
                .willReturn("place 11;14;11;16")
                .willReturn("place 11;15;11;17")
                .willReturn("place 15;15;15;17")
                .willReturn("place 12;0;12;2")
                .willReturn("place 12;1;12;3")
                .willReturn("place 12;4;12;6")
                .willReturn("place 12;5;12;7")
                .willReturn("place 12;8;12;10")
                .willReturn("place 12;9;12;11")
                .willReturn("place 12;12;12;14")
                .willReturn("place 12;13;12;15")
                .willReturn("place 12;16;13;0")
                .willReturn("place 12;17;13;1")
                .willReturn("place 13;2;13;4")
                .willReturn("place 13;3;13;5")
                .willReturn("place 13;6;13;8")
                .willReturn("place 13;7;13;9")
                .willReturn("place 13;10;13;12")
                .willReturn("place 13;11;13;13")
                .willReturn("place 13;14;13;16")
                .willReturn("place 13;15;13;17")
                .willReturn("place 14;0;14;2")
                .willReturn("place 14;1;14;3")
                .willReturn("place 14;4;14;6")
                .willReturn("place 14;5;14;7")
                .willReturn("place 14;8;14;10")
                .willReturn("place 14;9;14;11")
                .willReturn("place 14;12;14;14")
                .willReturn("place 14;13;14;15")
                .willReturn("place 14;16;15;0")
                .willReturn("place 14;17;15;1")
                .willReturn("place 15;2;15;4")
                .willReturn("place 15;3;15;5")
                .willReturn("place 15;6;15;8")
                .willReturn("place 15;7;15;9")
                .willReturn("place 15;10;15;12")
                .willReturn("place 15;11;15;13")
                .willReturn("place 15;14;15;16")
                .willReturn("place 16;0;16;2")
                .willReturn("place 16;1;16;3")
                .willReturn("place 16;4;16;6")
                .willReturn("place 16;5;16;7")
                .willReturn("place 16;8;16;10")
                .willReturn("place 16;9;16;11")
                .willReturn("place 16;12;16;14")
                .willReturn("place 16;13;16;15")
                .willReturn("place 16;16;17;0")
                .willReturn("place 16;17;17;1")
                .willReturn("place 17;2;17;4")
                .willReturn("place 17;3;17;5")
                .willReturn("place 17;6;17;8")
                .willReturn("place 17;7;17;9")
                .willReturn("place 17;10;17;12")
                .willReturn("place 17;11;17;13")
                .willReturn("place 17;14;17;16")
                .willReturn("place 17;15;17;17") //this should be draw
                .willReturn("quit");

        Start.game("standard", "18", "2");

        assertThat(terminalMock.isError()).isFalse();
        assertThat(terminalMock.getCaptor().getValue()).isEqualTo("draw");

    }

    @Test
    public void testResetAfterDraw() throws Exception {
        terminalMock.mock()
                .willReturn("place 0;0;0;2")
                .willReturn("place 0;1;0;3")
                .willReturn("place 0;4;0;6")
                .willReturn("place 0;5;0;7")
                .willReturn("place 0;8;0;10")
                .willReturn("place 0;9;0;11")
                .willReturn("place 0;12;0;14")
                .willReturn("place 0;13;0;15")
                .willReturn("place 0;16;1;0")
                .willReturn("place 0;17;1;1")
                .willReturn("place 1;2;1;4")
                .willReturn("place 1;3;1;5")
                .willReturn("place 1;6;1;8")
                .willReturn("place 1;7;1;9")
                .willReturn("place 1;10;1;12")
                .willReturn("place 1;11;1;13")
                .willReturn("place 1;14;1;16")
                .willReturn("place 1;15;1;17")
                .willReturn("place 2;0;2;2")
                .willReturn("place 2;1;2;3")
                .willReturn("place 2;4;2;6")
                .willReturn("place 2;5;2;7")
                .willReturn("place 2;8;2;10")
                .willReturn("place 2;9;2;11")
                .willReturn("place 2;12;2;14")
                .willReturn("place 2;13;2;15")
                .willReturn("place 2;16;3;0")
                .willReturn("place 2;17;3;1")
                .willReturn("place 3;2;3;4")
                .willReturn("place 3;3;3;5")
                .willReturn("place 3;6;3;8")
                .willReturn("place 3;7;3;9")
                .willReturn("place 3;10;3;12")
                .willReturn("place 3;11;3;13")
                .willReturn("place 3;14;3;16")
                .willReturn("place 3;15;3;17")
                .willReturn("place 7;15;7;17")
                .willReturn("place 4;0;4;2")
                .willReturn("place 4;1;4;3")
                .willReturn("place 4;4;4;6")
                .willReturn("place 4;5;4;7")
                .willReturn("place 4;8;4;10")
                .willReturn("place 4;9;4;11")
                .willReturn("place 4;12;4;14")
                .willReturn("place 4;13;4;15")
                .willReturn("place 4;16;5;0")
                .willReturn("place 4;17;5;1")
                .willReturn("place 5;2;5;4")
                .willReturn("place 5;3;5;5")
                .willReturn("place 5;6;5;8")
                .willReturn("place 5;7;5;9")
                .willReturn("place 5;10;5;12")
                .willReturn("place 5;11;5;13")
                .willReturn("place 5;14;5;16")
                .willReturn("place 5;15;5;17")
                .willReturn("place 6;0;6;2")
                .willReturn("place 6;1;6;3")
                .willReturn("place 6;4;6;6")
                .willReturn("place 6;5;6;7")
                .willReturn("place 6;8;6;10")
                .willReturn("place 6;9;6;11")
                .willReturn("place 6;12;6;14")
                .willReturn("place 6;13;6;15")
                .willReturn("place 6;16;7;0")
                .willReturn("place 6;17;7;1")
                .willReturn("place 7;2;7;4")
                .willReturn("place 7;3;7;5")
                .willReturn("place 7;6;7;8")
                .willReturn("place 7;7;7;9")
                .willReturn("place 7;10;7;12")
                .willReturn("place 7;11;7;13")
                .willReturn("place 7;14;7;16")
                .willReturn("place 8;0;8;2")
                .willReturn("place 8;1;8;3")
                .willReturn("place 8;4;8;6")
                .willReturn("place 8;5;8;7")
                .willReturn("place 8;8;8;10")
                .willReturn("place 8;9;8;11")
                .willReturn("place 8;12;8;14")
                .willReturn("place 8;13;8;15")
                .willReturn("place 8;16;9;0")
                .willReturn("place 8;17;9;1")
                .willReturn("place 9;2;9;4")
                .willReturn("place 9;3;9;5")
                .willReturn("place 9;6;9;8")
                .willReturn("place 9;7;9;9")
                .willReturn("place 9;10;9;12")
                .willReturn("place 9;11;9;13")
                .willReturn("place 9;14;9;16")
                .willReturn("place 9;15;9;17")
                .willReturn("place 10;0;10;2")
                .willReturn("place 10;1;10;3")
                .willReturn("place 10;4;10;6")
                .willReturn("place 10;5;10;7")
                .willReturn("place 10;8;10;10")
                .willReturn("place 10;9;10;11")
                .willReturn("place 10;12;10;14")
                .willReturn("place 10;13;10;15")
                .willReturn("place 10;16;11;0")
                .willReturn("place 10;17;11;1")
                .willReturn("place 11;2;11;4")
                .willReturn("place 11;3;11;5")
                .willReturn("place 11;6;11;8")
                .willReturn("place 11;7;11;9")
                .willReturn("place 11;10;11;12")
                .willReturn("place 11;11;11;13")
                .willReturn("place 11;14;11;16")
                .willReturn("place 11;15;11;17")
                .willReturn("place 15;15;15;17")
                .willReturn("place 12;0;12;2")
                .willReturn("place 12;1;12;3")
                .willReturn("place 12;4;12;6")
                .willReturn("place 12;5;12;7")
                .willReturn("place 12;8;12;10")
                .willReturn("place 12;9;12;11")
                .willReturn("place 12;12;12;14")
                .willReturn("place 12;13;12;15")
                .willReturn("place 12;16;13;0")
                .willReturn("place 12;17;13;1")
                .willReturn("place 13;2;13;4")
                .willReturn("place 13;3;13;5")
                .willReturn("place 13;6;13;8")
                .willReturn("place 13;7;13;9")
                .willReturn("place 13;10;13;12")
                .willReturn("place 13;11;13;13")
                .willReturn("place 13;14;13;16")
                .willReturn("place 13;15;13;17")
                .willReturn("place 14;0;14;2")
                .willReturn("place 14;1;14;3")
                .willReturn("place 14;4;14;6")
                .willReturn("place 14;5;14;7")
                .willReturn("place 14;8;14;10")
                .willReturn("place 14;9;14;11")
                .willReturn("place 14;12;14;14")
                .willReturn("place 14;13;14;15")
                .willReturn("place 14;16;15;0")
                .willReturn("place 14;17;15;1")
                .willReturn("place 15;2;15;4")
                .willReturn("place 15;3;15;5")
                .willReturn("place 15;6;15;8")
                .willReturn("place 15;7;15;9")
                .willReturn("place 15;10;15;12")
                .willReturn("place 15;11;15;13")
                .willReturn("place 15;14;15;16")
                .willReturn("place 16;0;16;2")
                .willReturn("place 16;1;16;3")
                .willReturn("place 16;4;16;6")
                .willReturn("place 16;5;16;7")
                .willReturn("place 16;8;16;10")
                .willReturn("place 16;9;16;11")
                .willReturn("place 16;12;16;14")
                .willReturn("place 16;13;16;15")
                .willReturn("place 16;16;17;0")
                .willReturn("place 16;17;17;1")
                .willReturn("place 17;2;17;4")
                .willReturn("place 17;3;17;5")
                .willReturn("place 17;6;17;8")
                .willReturn("place 17;7;17;9")
                .willReturn("place 17;10;17;12")
                .willReturn("place 17;11;17;13")
                .willReturn("place 17;14;17;16")
                .willReturn("place 17;15;17;17") //this should be draw
                .willReturn("reset")
                .willReturn("place 17;17;16;16")
                .willReturn("place 5;6;4;5")
                .willReturn("place 15;15;14;14")
                .willReturn("place 8;7;6;5")
                .willReturn("place 13;13;12;12")
                .willReturn("quit");

        Start.game("standard", "18", "2");

        assertThat(terminalMock.isError()).isFalse();
        assertThat(terminalMock.getCaptor().getValue()).isEqualTo("P1 wins");

    }

    @Test
    public void testPlaceAfterWinError() throws Exception {
        terminalMock.mock()
                .willReturn("place 0;0;1;0")
                .willReturn("place 0;1;1;1")
                .willReturn("place 2;0;3;0")
                .willReturn("place 2;1;3;1")
                .willReturn("place 4;0;5;0") //p1 wins here
                .willReturn("place 4;1;5;1") //this should not be allowed
                .willReturn("print")
                .willReturn("quit");

        Start.game("standard", "18", "2");

        assertThat(terminalMock.isError()).isTrue();
        assertThat(terminalMock.getCaptor().getValue()).isEqualTo( //make sure the invalid placement is not actually placed
                "P1 P2 ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **\n" +
                        "P1 P2 ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **\n" +
                        "P1 P2 ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **\n" +
                        "P1 P2 ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **\n" +
                        "P1 ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **\n" +
                        "P1 ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **\n" +
                        "** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **\n" +
                        "** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **\n" +
                        "** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **\n" +
                        "** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **\n" +
                        "** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **\n" +
                        "** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **\n" +
                        "** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **\n" +
                        "** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **\n" +
                        "** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **\n" +
                        "** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **\n" +
                        "** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **\n" +
                        "** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** ** **");
    }


    @Test
    public void testDraw() throws Exception {

        int boardSize = 18;

        BDDMockito.BDDMyOngoingStubbing<String> mocking = terminalMock.mock();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j += 2) {
                mocking = mocking.willReturn("place " + i + ";" + j + ";" + i + ";" + (j + 1));
            }
        }

        mocking.willReturn("quit");

        Start.game("standard", boardSize + "", "4");

        assertThat(terminalMock.isError()).isFalse();
        assertThat(terminalMock.getCaptor().getValue()).isEqualTo("draw");
    }
}