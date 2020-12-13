package com.cg.training.entity;
public class ApplicationBuilder 
{
		private String applicationId;

		public ApplicationBuilder withApplicationId(String applicationId) {
			this.applicationId = applicationId;
			return this;
		}

		public Application build() {
			return new Application();
		}
	

	
	}