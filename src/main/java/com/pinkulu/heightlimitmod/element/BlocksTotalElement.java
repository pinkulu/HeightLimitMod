package com.pinkulu.heightlimitmod.element;

import co.uk.isxander.evergreenhud.elements.ElementData;
import co.uk.isxander.evergreenhud.elements.type.SimpleTextElement;
import com.pinkulu.heightlimitmod.api.ApiManager;

public class BlocksTotalElement extends SimpleTextElement {

    @Override
    protected ElementData metadata() {
        return new ElementData("HLM: Total Height", "Shows how many blocks remaining before you reach the height limit.", "Hypixel");
    }

    @Override
    protected String getValue() {
        int limit = ApiManager.instance.getHeightLimit();
        if (limit == -1 || mc.thePlayer == null) {
            return "0";
        }
        return Integer.toString(limit);
    }

    @Override
    public String getDefaultDisplayTitle() {
        return "Limit";
    }

    @Override
    public void render(float partialTicks, int origin) {
        if (origin == 0) {
            if (ApiManager.instance.getHeightLimit() == -1 || mc.thePlayer == null) {
                return;
            }
        }

        super.render(partialTicks, origin);
    }
}
