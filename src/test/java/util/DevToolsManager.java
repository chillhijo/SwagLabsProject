package util;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v119.log.Log;
import org.openqa.selenium.devtools.v119.network.Network;

import java.util.Optional;

public class DevToolsManager {

    private DevTools devTools;

    public DevTools createDevToolsSession(ChromeDriver driver) {
        try {
            devTools = driver.getDevTools();
            devTools.createSession();
        } catch (SessionNotCreatedException e) {
            logError("Failed to create DevTools session", e);
        } catch (WebDriverException e) {
            logError("WebDriver exception while working with DevTools", e);
        } catch (Exception e) {
            logError("An unexpected exception occurred", e);
        }
        return devTools;
    }

    public void captureConsoleLogs() {
        if (devTools != null) {
            try {
                devTools.send(Log.enable());
                devTools.addListener(Log.entryAdded(), logEntry -> {
                    System.out.println("-------------------");
                    System.out.println("Level: " + logEntry.getLevel());
                    System.out.println("Text: " + logEntry.getText());
                    System.out.println("Broken URL: " + logEntry.getUrl());
                });
            } catch (Exception e) {
                logError("Problem capturing console logs", e);
            }
        }
    }

    public void captureNetworkResponses() {
        if (devTools != null) {
            try {
                devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

                devTools.addListener(Network.responseReceived(), responseReceived -> {
                    System.out.println("Request ID: " + responseReceived.getRequestId());
                    System.out.println("Status Code: " + responseReceived.getResponse().getStatus());
                    System.out.println("Name: " + responseReceived.getResponse().getUrl());
                });
            } catch (Exception e) {
                logError("Problem capturing network responses", e);
            }
        }
    }

    private void logError(String message, Exception e) {
        System.err.println(message + ": " + e.getMessage());
    }
}
