package com.example.helloworld.health;

import com.codahale.metrics.health.HealthCheck;
import com.example.helloworld.core.Template;
import com.google.common.base.Optional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TemplateHealthCheck extends HealthCheck {
	private final Template template;
	
	
	@Override
	protected Result check() throws Exception {
		template.render(Optional.of("woo"));
		template.render(Optional.<String> absent());
		return Result.healthy();
	}
}
