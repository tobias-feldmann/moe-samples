package de.fotaris.ios.ui;

import de.fotaris.retrofit.IpController;
import de.fotaris.retrofit.ResponseCallback;
import de.fotaris.retrofit.models.IpResponse;
import com.intel.moe.natj.general.Pointer;
import com.intel.moe.natj.general.ann.Owned;
import com.intel.moe.natj.general.ann.RegisterOnStartup;
import com.intel.moe.natj.objc.ObjCRuntime;
import com.intel.moe.natj.objc.ann.IBAction;
import com.intel.moe.natj.objc.ann.ObjCClassName;
import com.intel.moe.natj.objc.ann.Property;
import com.intel.moe.natj.objc.ann.Selector;

import ios.NSObject;
import ios.foundation.NSOperationQueue;
import ios.uikit.UIButton;
import ios.uikit.UILabel;
import ios.uikit.UIViewController;

@com.intel.moe.natj.general.ann.Runtime(ObjCRuntime.class)
@ObjCClassName("AppViewController")
@RegisterOnStartup
public class AppViewController extends UIViewController {

    @Owned
    @Selector("alloc")
    public static native AppViewController alloc();

    @Selector("init")
    public native AppViewController init();

    protected AppViewController(Pointer peer) {
        super(peer);
    }

    public UILabel ipLabel = null;
    public UIButton ipButton = null;
    private IpController ipController;

    @Override
    public void viewDidLoad() {
        ipLabel = getIpLabel();
        ipButton = getIpButton();
        ipController = new IpController();
        ipLabel.setText("");
    }


    @Property
    @Selector("getIp")
    public native UIButton getGetIp();

    @IBAction
    @Selector("BtnPressed_getIp:")
    public void BtnPressed_getIp(NSObject sender) {
        ipController.getIp(new ResponseCallback<IpResponse>() {
            @Override
            public void success(IpResponse response) {

                NSOperationQueue.mainQueue().addOperationWithBlock( () -> {
                    ipLabel.setText(response.getOrigin());
                });
            }

            @Override
            public void error() {
            }
        });
    }

    @Property
    @Selector("ipLabel")
    public native UILabel getIpLabel();


    @Property
    @Selector("ipButton")
    public native UIButton getIpButton();
}
