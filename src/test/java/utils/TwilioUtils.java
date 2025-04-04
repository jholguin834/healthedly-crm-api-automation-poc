package utils;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

import java.net.URI;

public class TwilioUtils {

    public static final String ACCOUNT_SID = EnvLoader.get("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = EnvLoader.get("TWILIO_AUTH_TOKEN");
    private static final String FROM = EnvLoader.get("TWILIO_FROM_NUMBER");
    private static final String TO = EnvLoader.get("TWILIO_TO_NUMBER");

    public static void makeTestCall() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Call call = Call.creator(
                new PhoneNumber(TO),        // To
                new PhoneNumber(FROM),      // From (Twilio verified number)
                URI.create("http://demo.twilio.com/docs/voice.xml")
        ).create();

        System.out.println("Call SID: " + call.getSid());
        System.out.println("Call SID: " + call.getAccountSid());
        System.out.println("Call SID: " + call.getAnsweredBy());
        System.out.println("Call SID: " + call.getParentCallSid());
        System.out.println("Call SID: " + call.getGroupSid());
        System.out.println("Call SID: " + call.getApiVersion());
        System.out.println("Call SID: " + call.getCallerName());
        System.out.println("Call SID: " + call.getDirection());
        System.out.println("Call SID: " + call.getDuration());
        System.out.println("Call SID: " + call.getForwardedFrom());
        System.out.println("Call SID: " + call.getFrom());
        System.out.println("Call SID: " + call.getFromFormatted());
        System.out.println("Call SID: " + call.getPhoneNumberSid());
        System.out.println("Call SID: " + call.getPrice());
        System.out.println("Call SID: " + call.getQueueTime());
        System.out.println("Call SID: " + call.getTo());
        System.out.println("Call SID: " + call.getToFormatted());
        System.out.println("Call SID: " + call.getTrunkSid());
        System.out.println("Call SID: " + call.getUri());
        System.out.println("Call SID: " + call.toString());
        System.out.println("Call SID: " + call.getDateCreated());
        System.out.println("Call SID: " + call.getDateUpdated());
        System.out.println("Call SID: " + call.getQueueTime());
        System.out.println("Call SID: " + call.getPrice());
        System.out.println("Call SID: " + call.getPriceUnit());
    }
}
