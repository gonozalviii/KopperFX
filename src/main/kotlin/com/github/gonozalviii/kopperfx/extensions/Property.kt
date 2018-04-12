/*
 * Copyright 2018 Peer Schoenhusen & Ramon Victor
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.gonozalviii.kopperfx.extensions

import javafx.beans.value.*
import kotlin.reflect.KProperty

/**
 * Property delegates
 */
operator fun <T> WritableValue<T>.getValue(thisRef: Any?, property: KProperty<*>): T = this.value

operator fun <T> WritableValue<T>.setValue(thisRef: Any?, property: KProperty<*>, value: T) = setValue(value)

operator fun WritableIntegerValue.getValue(thisRef: Any?, property: KProperty<*>): Int = get()

operator fun WritableIntegerValue.setValue(thisRef: Any?, property: KProperty<*>, value: Int) = set(value)

operator fun WritableLongValue.getValue(thisRef: Any?, property: KProperty<*>): Long = get()

operator fun WritableLongValue.setValue(thisRef: Any?, property: KProperty<*>, value: Long) = set(value)

operator fun WritableFloatValue.getValue(thisRef: Any?, property: KProperty<*>): Float = get()

operator fun WritableFloatValue.setValue(thisRef: Any?, property: KProperty<*>, value: Float) = set(value)

operator fun WritableDoubleValue.getValue(thisRef: Any?, property: KProperty<*>): Double = get()

operator fun WritableDoubleValue.setValue(thisRef: Any?, property: KProperty<*>, value: Double) = set(value)

