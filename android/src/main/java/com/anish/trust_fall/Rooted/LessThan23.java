package com.anish.trust_fall.Rooted;

import com.anish.trust_fall.TrustFallPlugin;

import java.io.File;

public class LessThan23 implements CheckApiVersion {

    @Override
    public boolean checkRooted() {

        return canExecuteCommand(TrustFallPlugin.decodeString("L3N5c3RlbS94YmluL3doaWNoIHN1")) || isSuperuserPresent();
    }

    // executes a command on the system
    private static boolean canExecuteCommand(String command) {
        boolean executeResult;
        try {
            Process process = Runtime.getRuntime().exec(command);
            if (process.waitFor() == 0) {
                executeResult = true;
            } else {
                executeResult = false;
            }
        } catch (Exception e) {
            executeResult = false;
        }

        return executeResult;
    }

    private static boolean isSuperuserPresent() {
        // Check if /system/app/Superuser.apk is present
        String[] paths = {
                "L3N5c3RlbS9hcHAvU3VwZXJ1c2VyLmFwaw==",
                "L3NiaW4vc3U=",
                "L3N5c3RlbS9iaW4vc3U=",
                "L3N5c3RlbS94YmluL3N1",
                "L2RhdGEvbG9jYWwveGJpbi9zdQ==",
                "L2RhdGEvbG9jYWwvYmluL3N1",
                "L3N5c3RlbS9zZC94YmluL3N1",
                "L3N5c3RlbS9iaW4vZmFpbHNhZmUvc3U=",
                "L2RhdGEvbG9jYWwvc3U="
        };

        for (String path : paths) {
            if (new File(TrustFallPlugin.decodeString(path)).exists()) {
                return true;
            }
        }

        return false;
    }

}
