package kotlin

//
// NOTE THIS FILE IS AUTO-GENERATED by the GenerateStandardLib.kt
// See: https://github.com/JetBrains/kotlin/tree/master/libraries/stdlib
//

import java.util.*

import java.util.Collections // TODO: it's temporary while we have java.util.Collections in js

/**
 * Returns a progression that goes over the same range in the opposite direction with the same step
 */
public fun ByteProgression.reversed(): ByteProgression {
    return ByteProgression(end, start, -increment)
}

/**
 * Returns a progression that goes over the same range in the opposite direction with the same step
 */
public fun CharProgression.reversed(): CharProgression {
    return CharProgression(end, start, -increment)
}

/**
 * Returns a progression that goes over the same range in the opposite direction with the same step
 */
public fun DoubleProgression.reversed(): DoubleProgression {
    return DoubleProgression(end, start, -increment)
}

/**
 * Returns a progression that goes over the same range in the opposite direction with the same step
 */
public fun FloatProgression.reversed(): FloatProgression {
    return FloatProgression(end, start, -increment)
}

/**
 * Returns a progression that goes over the same range in the opposite direction with the same step
 */
public fun IntProgression.reversed(): IntProgression {
    return IntProgression(end, start, -increment)
}

/**
 * Returns a progression that goes over the same range in the opposite direction with the same step
 */
public fun LongProgression.reversed(): LongProgression {
    return LongProgression(end, start, -increment)
}

/**
 * Returns a progression that goes over the same range in the opposite direction with the same step
 */
public fun ShortProgression.reversed(): ShortProgression {
    return ShortProgression(end, start, -increment)
}

/**
 * Returns a progression that goes over this range in reverse direction
 */
public fun ByteRange.reversed(): ByteProgression {
    return ByteProgression(end, start, -1)
}

/**
 * Returns a progression that goes over this range in reverse direction
 */
public fun CharRange.reversed(): CharProgression {
    return CharProgression(end, start, -1)
}

/**
 * Returns a progression that goes over this range in reverse direction
 */
public fun DoubleRange.reversed(): DoubleProgression {
    return DoubleProgression(end, start, -1.0)
}

/**
 * Returns a progression that goes over this range in reverse direction
 */
public fun FloatRange.reversed(): FloatProgression {
    return FloatProgression(end, start, -1.0f)
}

/**
 * Returns a progression that goes over this range in reverse direction
 */
public fun IntRange.reversed(): IntProgression {
    return IntProgression(end, start, -1)
}

/**
 * Returns a progression that goes over this range in reverse direction
 */
public fun LongRange.reversed(): LongProgression {
    return LongProgression(end, start, -1.toLong())
}

/**
 * Returns a progression that goes over this range in reverse direction
 */
public fun ShortRange.reversed(): ShortProgression {
    return ShortProgression(end, start, -1)
}

/**
 * Returns a progression that goes over the same range with the given step
 */
public fun ByteProgression.step(step: Int): ByteProgression {
    checkStepIsPositive(step > 0, step)
    return ByteProgression(start, end, if (increment > 0) step else -step)
}

/**
 * Returns a progression that goes over the same range with the given step
 */
public fun CharProgression.step(step: Int): CharProgression {
    checkStepIsPositive(step > 0, step)
    return CharProgression(start, end, if (increment > 0) step else -step)
}

/**
 * Returns a progression that goes over the same range with the given step
 */
public fun DoubleProgression.step(step: Double): DoubleProgression {
    checkStepIsPositive(step > 0, step)
    return DoubleProgression(start, end, if (increment > 0) step else -step)
}

/**
 * Returns a progression that goes over the same range with the given step
 */
public fun FloatProgression.step(step: Float): FloatProgression {
    checkStepIsPositive(step > 0, step)
    return FloatProgression(start, end, if (increment > 0) step else -step)
}

/**
 * Returns a progression that goes over the same range with the given step
 */
public fun IntProgression.step(step: Int): IntProgression {
    checkStepIsPositive(step > 0, step)
    return IntProgression(start, end, if (increment > 0) step else -step)
}

/**
 * Returns a progression that goes over the same range with the given step
 */
public fun LongProgression.step(step: Long): LongProgression {
    checkStepIsPositive(step > 0, step)
    return LongProgression(start, end, if (increment > 0) step else -step)
}

/**
 * Returns a progression that goes over the same range with the given step
 */
public fun ShortProgression.step(step: Int): ShortProgression {
    checkStepIsPositive(step > 0, step)
    return ShortProgression(start, end, if (increment > 0) step else -step)
}

/**
 * Returns a progression that goes over this range with given step
 */
public fun ByteRange.step(step: Int): ByteProgression {
    checkStepIsPositive(step > 0, step)
    return ByteProgression(start, end, step)
}

/**
 * Returns a progression that goes over this range with given step
 */
public fun CharRange.step(step: Int): CharProgression {
    checkStepIsPositive(step > 0, step)
    return CharProgression(start, end, step)
}

/**
 * Returns a progression that goes over this range with given step
 */
public fun DoubleRange.step(step: Double): DoubleProgression {
    if (step.isNaN()) throw IllegalArgumentException("Step must not be NaN")
    checkStepIsPositive(step > 0, step)
    return DoubleProgression(start, end, step)
}

/**
 * Returns a progression that goes over this range with given step
 */
public fun FloatRange.step(step: Float): FloatProgression {
    if (step.isNaN()) throw IllegalArgumentException("Step must not be NaN")
    checkStepIsPositive(step > 0, step)
    return FloatProgression(start, end, step)
}

/**
 * Returns a progression that goes over this range with given step
 */
public fun IntRange.step(step: Int): IntProgression {
    checkStepIsPositive(step > 0, step)
    return IntProgression(start, end, step)
}

/**
 * Returns a progression that goes over this range with given step
 */
public fun LongRange.step(step: Long): LongProgression {
    checkStepIsPositive(step > 0, step)
    return LongProgression(start, end, step)
}

/**
 * Returns a progression that goes over this range with given step
 */
public fun ShortRange.step(step: Int): ShortProgression {
    checkStepIsPositive(step > 0, step)
    return ShortProgression(start, end, step)
}

