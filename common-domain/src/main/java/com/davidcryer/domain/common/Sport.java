package com.davidcryer.domain.common;

import javax.validation.constraints.NotNull;
import java.util.Date;

abstract class Sport {

    static abstract class Report {
        @NotNull
        private Date date;

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
    }
}
