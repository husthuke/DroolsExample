package com.us.person;

import org.drools.core.spi.Activation;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;

/**
 * Created by yangyibo on 16/12/20.
 */
public class TestAgendaFilter implements AgendaFilter {

    private String startName;

    public TestAgendaFilter(String startName) {
        this.startName = startName;
    }

    //accept 返回true 规则执行
    //Match 符合LHS部分的working memory集合
    public boolean accept(Match match) {
        String ruleName = match.getRule().getName();
        if (ruleName.startsWith(this.startName)) {
            return true;
        } else {
            return false;
        }
    }
}
