package com.anish.trust_fall.Rooted;

import com.anish.trust_fall.TrustFallPlugin;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class GreaterThan23 implements CheckApiVersion {
    @Override
    public boolean checkRooted() {
        return checkRootMethod1() || checkRootMethod2();
    }

    private boolean checkRootMethod1() {
        String[] paths = {
                "L3N5c3RlbS9hcHAvU3VwZXJ1c2VyLmFwaw==",
                "L3NiaW4vc3U=",
                "L3N5c3RlbS9iaW4vc3U=",
                "L3N5c3RlbS94YmluL3N1",
                "L2RhdGEvbG9jYWwveGJpbi9zdQ==",
                "L2RhdGEvbG9jYWwvYmluL3N1",
                "L3N5c3RlbS9zZC94YmluL3N1",
                "L3N5c3RlbS9iaW4vZmFpbHNhZmUvc3U=",
                "L2RhdGEvbG9jYWwvc3U="};
        for (String path : paths) {
            if (new File(TrustFallPlugin.decodeString(path)).exists()) return true;
        }
        return false;
    }

    private boolean checkRootMethod2() {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(new String[]{TrustFallPlugin.decodeString("L3N5c3RlbS94YmluL3doaWNo"), TrustFallPlugin.decodeString("c3U=")});
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            if (in.readLine() != null) return true;
            return false;
        } catch (Throwable t) {
            return false;
        } finally {
            if (process != null) process.destroy();
        }
    }
}
