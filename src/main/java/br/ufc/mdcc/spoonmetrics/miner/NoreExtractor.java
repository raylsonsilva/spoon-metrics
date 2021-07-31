package br.ufc.mdcc.spoonmetrics.miner;

import br.ufc.mdcc.spoonmetrics.model.Dataset;
import br.ufc.mdcc.spoonmetrics.model.Measure;
import br.ufc.mdcc.spoonmetrics.model.Metric;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtThrow;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.visitor.filter.TypeFilter;

public class NoreExtractor extends AbstractProcessor<CtClass<?>> {
	
	@Override
	public void process(CtClass<?> element) 
	{
		String name = element.getQualifiedName();
		TypeFilter<CtThrow> throwFilter = new TypeFilter<CtThrow>(CtThrow.class);
		double qtdExceptions = 0;
		
		for (CtThrow e : element.getElements(throwFilter)) 
		{
			if(e != null){ qtdExceptions+=1; }
		}
		
		Dataset.store(name, new Measure(Metric.NORE, qtdExceptions));
	}
	
}
