package us.bojie.shoppingbo.generators;

import us.bojie.latte.annotations.EntryGenerator;
import us.bojie.latte.wechat.templates.WXEntryTemplate;

/**
 * Created by bojiejiang on 2/18/18.
 */
@EntryGenerator(
        packageName = "us.bojie.shoppingbo",
        entryTemplete = WXEntryTemplate.class
)
public interface WeChatEntry {
}
