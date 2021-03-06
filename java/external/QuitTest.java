package external;

import static org.junit.Assert.*;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import base.Start;
import base.TerminalMock;
import edu.kit.informatik.Terminal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * QuitTest
 *
 * @author Valentin Wagner
 *         09.02.18
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Terminal.class)
class QuitTest {

    private TerminalMock terminalMock;

    public QuitTest() {
    }

    @Before
    public void init() {
        this.terminalMock = new TerminalMock();
    }


    @Test
    public void testQuitWithoutArgs() throws Exception {
        terminalMock.mock()
                .willReturn("quit ") //space at the end
                .willReturn("quit");

        Start.game("torus", "18", "2");
        assertThat(terminalMock.isError()).isTrue();

        terminalMock.mock()
                .willReturn("quit 346;aww") //args
                .willReturn("quit");

        Start.game("standard", "18", "2");
        assertThat(terminalMock.isError()).isTrue();

        terminalMock.mock()
                .willReturn(" quit ") //spaces
                .willReturn("quit");

        Start.game("torus", "18", "2");
        assertThat(terminalMock.isError()).isTrue();
    }


}