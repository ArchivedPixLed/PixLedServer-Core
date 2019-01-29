package com.pixled.pixledserver.core.state.base;

import com.pixled.pixledserver.core.ToggleState;

import javax.persistence.*;

@MappedSuperclass
public abstract class State {
    @Id
    @GeneratedValue
    private Integer id;

    @Enumerated(EnumType.STRING)
    private ToggleState toggleState;

    public State() {
        toggleState = ToggleState.OFF;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ToggleState getToggleState() {
        return toggleState;
    }

    public void setToggleState(ToggleState toggleState) {
        this.toggleState = toggleState;
    }
}
