package com.zking.ssm.model;

import lombok.Data;

@Data
public class JiaKu {
    private String jIdentity;

    private String jName;

    public JiaKu(String jIdentity, String jName) {
        this.jIdentity = jIdentity;
        this.jName = jName;
    }

    public JiaKu() {
        super();
    }

    public String getjIdentity() {
        return jIdentity;
    }

    public void setjIdentity(String jIdentity) {
        this.jIdentity = jIdentity;
    }

    public String getjName() {
        return jName;
    }

    public void setjName(String jName) {
        this.jName = jName;
    }
}