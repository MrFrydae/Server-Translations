package fr.catcore.translated.server.mixin;

import fr.catcore.translated.server.TranslatedServer;
import fr.catcore.translated.server.resource.language.ServerLanguage;
import net.minecraft.util.Language;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Language.class)
public class MixinLanguage {

    @Inject(method = "create", cancellable = true, at = @At("RETURN"))
    private static void server_GetInstance(CallbackInfoReturnable<Language> cir) {
        TranslatedServer.onInitialize();
        cir.setReturnValue(ServerLanguage.getInstance());
    }
}
