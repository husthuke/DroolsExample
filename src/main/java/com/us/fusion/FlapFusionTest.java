package com.us.fusion;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;
import org.kie.internal.runtime.StatelessKnowledgeSession;


/**
 * Created by yangyibo on 17/1/3.
 */
public class FlapFusionTest {

    private static StatelessKnowledgeSession session;


    public static void main(String[] args) throws Exception {


        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
                .newKnowledgeBuilder();
//		kbuilder.add(ResourceFactory.newClassPathResource("com/us/fusion/FlapowanieFusionHB.drl"),
//				ResourceType.DRL);
        kbuilder.add(ResourceFactory.newClassPathResource("com/us/fusion/WaitingForDysplayingFusionHB.drl"),
                ResourceType.DRL);

        if (kbuilder.hasErrors()) {
            System.err.println(kbuilder.getErrors().toString());
        }

        KieBaseConfiguration config = KnowledgeBaseFactory.newKnowledgeBaseConfiguration();

        config.setOption( EventProcessingOption.STREAM );//设置为流模式

        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase(config);
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());

        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();

        linkDown(ksession, "192.168.0.162");
        linkUp(ksession, "192.168.0.162");

        linkDown(ksession, "192.168.0.162");
        linkUp(ksession, "192.168.0.162");

        linkDown(ksession, "192.168.0.162");
        linkUp(ksession, "192.168.0.162");

        linkDown(ksession, "192.168.0.162");
        linkUp(ksession, "192.168.0.162");
        fireRulesAfter(ksession, 3000);


        System.exit(0);
    }

    private static void linkUp(StatefulKnowledgeSession ksession, String interfejs)
            throws InterruptedException {
        ksession.insert(new EventTest("SNMP_Link_Up", interfejs));
        fireRulesAfter(ksession, 400);
    }

    private static void fireRulesAfter(StatefulKnowledgeSession ksession, long millis) throws InterruptedException {
        Thread.sleep(millis);
        ksession.fireAllRules();
    }

    private static void linkDown(StatefulKnowledgeSession ksession, String interfejs)
            throws InterruptedException {
        ksession.insert(new EventTest("SNMP_Link_Down", interfejs));
        fireRulesAfter(ksession, 400);
    }
}
