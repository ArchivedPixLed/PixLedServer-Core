package com.pixled.pixledserver.core.state.base;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pixled.pixledserver.core.ToggleState;

public class StateDto {

    private ToggleState toggleState;

    @JsonCreator
    public StateDto(
            @JsonProperty("toggle") String toggle
    ){
        this.toggleState = toggle.equals("ON") ? ToggleState.ON : ToggleState.OFF;
    }

    public StateDto(State state) {
        toggleState = state.getToggleState();
    }

    public ToggleState getToggleState() {
        return toggleState;
    }

    public void setToggleState(ToggleState toggleState) {
        this.toggleState = toggleState;
    }
}
