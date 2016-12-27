package com.us.person;

import org.kie.api.io.ResourceType;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderErrors;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.io.ResourceFactory;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by yangyibo on 16/12/19.
 * check  rules is work
 */
public class KnowledgeBuilderTest {
    public static void main(String[] args) {

        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("com/us/person/rules.drl",
                KnowledgeBuilderTest.class), ResourceType.DRL);
        if (kbuilder.hasErrors()) {
            System.out.println("规则中存在错误,错误消息如下:");
            //Errors 中有四个信息getSeverity、getMessage、getLines、getResource
            //[14,13]: [ERR 102] Line 14:13 mismatched input '2' in rule "salience"
            String error = kbuilder.getErrors().toString();
            System.out.println("error:" + error);
        }
        if (kbuilder.hasErrors()) {

            KnowledgeBuilderErrors kbuidlerErrors = kbuilder.getErrors();
            for (Iterator
                 iter = kbuidlerErrors.iterator(); iter.hasNext(); ) {
                System.out.println(iter.next());
            }
        }
        Collection<KnowledgePackage> kpackage=kbuilder.getKnowledgePackages();//产生规则包的集合


    }
}
