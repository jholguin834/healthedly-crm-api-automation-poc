package services.twilio;

import org.testng.annotations.Test;
import utils.TwilioUtils;

public class TwilioTest {

    @Test(groups = {"integration"})
    public void simulateVoiceCall() {
        TwilioUtils.makeTestCall();
    }
}
