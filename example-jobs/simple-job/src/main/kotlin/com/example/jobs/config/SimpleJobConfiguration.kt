package com.example.jobs.config

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableBatchProcessing
class SimpleJobConfiguration(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory
) {

    @Bean
    fun job(): Job =
        jobBuilderFactory.get(JOB_NAME)
            .start(firstStep())
            .next(secondStep())
            .next(thirdStep())
            .build()

    @Bean
    fun firstStep(): Step =
        stepBuilderFactory.get("step-1")
            .tasklet { _, _ ->
                println(">> First Step")
                RepeatStatus.FINISHED
            }
            .build()

    @Bean
    fun secondStep(): Step =
        stepBuilderFactory.get("step-2")
            .tasklet { _, _ ->
                println(">> Second Step")
                RepeatStatus.FINISHED
            }
            .build()

    @Bean
    fun thirdStep(): Step =
        stepBuilderFactory.get("step-2")
            .tasklet { _, _ ->
                println(">> Third Step")
                RepeatStatus.FINISHED
            }
            .build()

    companion object {
        private const val JOB_NAME = "simple-job"
    }
}
