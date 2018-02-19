package us.bojie.shoppingbo.generators;

import us.bojie.latte.annotations.PayEntryGenerator;
import us.bojie.latte.wechat.templates.WPayEntryTemplate;

/**
 * Created by bojiejiang on 2/18/18.
 */

@PayEntryGenerator(
        packageName = "us.bojie.shoppingbo",
        payEntryTemplete = WPayEntryTemplate.class
)
public interface WeChatPayEntry {
}
