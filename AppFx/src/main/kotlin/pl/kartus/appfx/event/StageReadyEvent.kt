package pl.kartus.appfx.event

import javafx.stage.Stage
import org.springframework.context.ApplicationEvent

class StageReadyEvent(val stage: Stage) : ApplicationEvent(stage)