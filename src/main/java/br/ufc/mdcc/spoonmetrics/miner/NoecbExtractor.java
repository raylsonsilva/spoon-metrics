package br.ufc.mdcc.spoonmetrics.miner;

import br.ufc.mdcc.spoonmetrics.model.Dataset;
import br.ufc.mdcc.spoonmetrics.model.Measure;
import br.ufc.mdcc.spoonmetrics.model.Metric;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCatch;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.visitor.filter.TypeFilter;

public class NoecbExtractor extends AbstractProcessor<CtClass<?>> {
	
	@Override
	public void process(CtClass<?> element) 
	{
		String name = element.getQualifiedName();
		TypeFilter<CtCatch> catchFilter = new TypeFilter<CtCatch>(CtCatch.class);
		double qtdCatchs = 0;
		
		for (CtCatch e : element.getElements(catchFilter)) 
		{
			if(e.getBody().getStatements().size()==0){ qtdCatchs+=1; }
		}
		
		Dataset.store(name, new Measure(Metric.NOECB, qtdCatchs));
	}
	
}
