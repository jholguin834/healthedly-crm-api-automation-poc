package services.twilio;

import org.testng.annotations.Test;
import utils.TwilioUtils;

public class TwilioTest {

    @Test(groups = {"integration"})
    public void simulateVoiceCall_SCRUM_T13() {
        TwilioUtils.makeTestCall();
    }
}
