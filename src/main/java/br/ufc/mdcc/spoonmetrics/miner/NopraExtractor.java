package br.ufc.mdcc.spoonmetrics.miner;

import br.ufc.mdcc.spoonmetrics.model.Dataset;
import br.ufc.mdcc.spoonmetrics.model.Measure;
import br.ufc.mdcc.spoonmetrics.model.Metric;
import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.ModifierKind;
import spoon.reflect.reference.CtFieldReference;

public class NopraExtractor extends AbstractProcessor<CtClass<?>> {

	@Override
	public void process(CtClass<?> element) 
	{
		String name = element.getQualifiedName();
		double fieldsCount = 0;
		
		for (CtFieldReference<?> e : element.getDeclaredFields()) 
		{			
			if(e.getModifiers().contains(ModifierKind.PRIVATE)){ fieldsCount+=1; }
		}
		
		Dataset.store(name, new Measure(Metric.NOPRA, fieldsCount));
	}
	
}
