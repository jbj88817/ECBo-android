package us.bojie.shoppingbo.generators;

import us.bojie.latte.annotations.AppRegisterGenerator;
import us.bojie.latte.wechat.templates.AppRegisterTemplate;

/**
 * Created by bojiejiang on 2/18/18.
 */

@AppRegisterGenerator(
        packageName = "us.bojie.shoppingbo",
        registerTemplete = AppRegisterTemplate.class
)
public interface AppRegister {
}
