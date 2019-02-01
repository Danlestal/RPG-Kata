RPG-Kata

As described in https://github.com/ardalis/kata-catalog


I am gonna use for rendering:
https://www.lwjgl.org/



// The amount of time we want to simulate each step, in milliseconds
// (written as implicit frame-rate)
timeDelta = 1000/30
timeAccumulator = 0
while ( game should run )
{
  timeSimulatedThisIteration = 0
  startTime = currentTime()

  while ( timeAccumulator >= timeDelta )
  {
    stepGameState( timeDelta )
    timeAccumulator -= timeDelta
    timeSimulatedThisIteration += timeDelta
  }

  stepAnimation( timeSimulatedThisIteration )

  renderFrame() // OpenGL frame drawing code goes here

  handleUserInput()

  timeAccumulator += currentTime() - startTime 
}
