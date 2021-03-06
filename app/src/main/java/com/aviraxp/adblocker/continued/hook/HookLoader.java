package com.aviraxp.adblocker.continued.hook;

import java.util.HashSet;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class HookLoader implements IXposedHookLoadPackage, IXposedHookZygoteInit {

    static HashSet<String> actViewList;
    static HashSet<String> actViewList_aggressive;
    static HashSet<String> hideList;
    static HashSet<String> hostsList;
    static HashSet<String> whiteList;
    static HashSet<String> receiversList;
    static HashSet<String> servicesList;
    static HashSet<String> regexList;

    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        new ActViewHook().hook(lpparam);
        new BackPressHook().hook(lpparam);
        new DonateHook().hook(lpparam);
        new HidingHook().hook(lpparam);
        new HostsHook().hook(lpparam);
        new ReceiversHook().hook(lpparam);
        new SelfHook().hook(lpparam);
        new ServicesHook().hook(lpparam);
        new WebViewHook().hook(lpparam);
    }

    public void initZygote(StartupParam startupParam) throws Throwable {
        ActViewHook.init(startupParam);
        HidingHook.init(startupParam);
        HostsHook.init(startupParam);
        ReceiversHook.init(startupParam);
        ServicesHook.init(startupParam);
        WebViewHook.init(startupParam);
    }
}
