package br.ufc.mdcc.spoonmetrics.miner;

import br.ufc.mdcc.spoonmetrics.model.Dataset;
import br.ufc.mdcc.spoonmetrics.model.Measure;
import br.ufc.mdcc.spoonmetrics.model.Metric;
import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.ModifierKind;

public class NopmExtractor extends AbstractProcessor<CtClass<?>> {
	
	@Override
	public void process(CtClass<?> element) 
	{
		String name = element.getQualifiedName();
		double fieldsCount = 0;
		
		for (CtMethod<?> e : element.getMethods()) 
		{
			if(e.getModifiers().contains(ModifierKind.PUBLIC)){ fieldsCount+=1; }
		}
		
		Dataset.store(name, new Measure(Metric.NOPM, fieldsCount));
	}
	
}
