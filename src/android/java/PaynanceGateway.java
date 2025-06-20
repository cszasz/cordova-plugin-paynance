package eatwithme.paynancegateway;

import android.content.Intent;
import android.net.Uri;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PaynanceGateway extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if ("openGateway".equals(action)) {
            JSONObject params = args.getJSONObject(0);

            String baseUrl = "paynance://sideapp/gateway";
            Uri.Builder uriBuilder = Uri.parse(baseUrl).buildUpon();

            // Add all known params
            uriBuilder.appendQueryParameter("ownerAppPackage", params.optString("ownerAppPackage", ""));
            uriBuilder.appendQueryParameter("ownerAppDeepLinkCallback",
                    params.optString("ownerAppDeepLinkCallback", ""));
            uriBuilder.appendQueryParameter("sessionId", params.optString("sessionId", ""));
            uriBuilder.appendQueryParameter("sourceCode", params.optString("sourceCode", ""));
            uriBuilder.appendQueryParameter("terminalId", params.optString("terminalId", ""));
            uriBuilder.appendQueryParameter("cashRegisterId", params.optString("cashRegisterId", ""));
            uriBuilder.appendQueryParameter("amount", params.optString("amount", ""));
            uriBuilder.appendQueryParameter("currencyCode", params.optString("currencyCode", ""));
            uriBuilder.appendQueryParameter("merchantReference", params.optString("merchantReference", ""));
            uriBuilder.appendQueryParameter("customerTrns", params.optString("customerTrns", ""));
            uriBuilder.appendQueryParameter("tipAmount", params.optString("tipAmount", ""));
            uriBuilder.appendQueryParameter("action", params.optString("action", "sale"));

            Intent intent = new Intent(Intent.ACTION_VIEW, uriBuilder.build());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);

            try {
                cordova.getActivity().startActivity(intent);
                callbackContext.success("Intent launched");
            } catch (Exception e) {
                callbackContext.error("Failed to launch intent: " + e.getMessage());
            }

            return true;
        }

        return false;
    }
}
