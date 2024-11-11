#import "POPAnimationExtras.h"

#import "POPAnimationPrivate.h"
#import "POPMath.h"

#if TARGET_OS_IPHONE
#import <UIKit/UIKit.h>
#endif

#if TARGET_IPHONE_SIMULATOR
UIKIT_EXTERN CGFloat UIAnimationDragCoefficient(); // UIKit private drag coeffient, use judiciously
#endif

CGFloat POPAnimationDragCoefficient()
{
#if TARGET_IPHONE_SIMULATOR
  return UIAnimationDragCoefficient();
#else
  return 1.0;
#endif
}

@implementation CAAnimation (POPAnimationExtras)

- (void)pop_applyDragCoefficient
{
  CGFloat k = POPAnimationDragCoefficient();
  if (k != 0 && k != 1)
    self.speed = 1 / k;
}

@end

@implementation POPSpringAnimation (POPAnimationExtras)

static const CGFloat POPBouncy3NormalizationRange = 10.0;
static const CGFloat POPBouncy3NormalizationScale = 1.5;
static const CGFloat POPBouncy3BouncinessNormalizedMin = 1.0;
static const CGFloat POPBouncy3BouncinessNormalizedMax = 2.3;
static const CGFloat POPBouncy3SpeedNormalizedMin = 0.1;
static const CGFloat POPBouncy3SpeedNormalizedMax = 1000;
static const CGFloat POPBouncy3FrictionInterpolationMax = 0.02;

+ (void)convertBounciness:(CGFloat)bounciness speed:(CGFloat)speed toTension:(CGFloat *)outTension friction:(CGFloat *)outFriction mass:(CGFloat *)outMass
{
  double b = normalize(bounciness / POPBouncy3NormalizationScale, 0, POPBouncy3NormalizationRange);
  b = project_normal(b, POPBouncy3BouncinessNormalizedMin, POPBouncy3BouncinessNormalizedMax);

  double s = normalize(speed / POPBouncy3NormalizationScale, 0, POPBouncy3NormalizationRange);

  CGFloat tension = project_normal(s, POPBouncy3SpeedNormalizedMin, POPBouncy3SpeedNormalizedMax);
  CGFloat friction = quadratic_out_interpolation(b, b3_nobounce(tension), POPBouncy3FrictionInterpolationMax);

  tension = POP_ANIMATION_TENSION_FOR_QC_TENSION(tension);
  friction = POP_ANIMATION_FRICTION_FOR_QC_FRICTION(friction);

  if (outTension) {
    *outTension = tension;
  }

  if (outFriction) {
    *outFriction = friction;
  }

  if (outMass) {
    *outMass = 1.0;
  }
}

+ (void)convertTension:(CGFloat)tension friction:(CGFloat)friction toBounciness:(CGFloat *)outBounciness speed:(CGFloat *)outSpeed
{
  // Convert to QC values, in which our calculations are done.
  CGFloat qcFriction = QC_FRICTION_FOR_POP_ANIMATION_FRICTION(friction);
  CGFloat qcTension = QC_TENSION_FOR_POP_ANIMATION_TENSION(tension);

  CGFloat nobounceTension = b3_nobounce(qcTension);
  CGFloat bounciness1, bounciness2;

  quadratic_solve((nobounceTension - POPBouncy3FrictionInterpolationMax),      // a
                  2 * (POPBouncy3FrictionInterpolationMax - nobounceTension),  // b
                  (nobounceTension - qcFriction),                             // c
                  bounciness1,                                                // x1
                  bounciness2);                                               // x2


  // Choose the quadratic solution within the normalized bounciness range
  CGFloat projectedNormalizedBounciness = (bounciness2 < POPBouncy3BouncinessNormalizedMax) ? bounciness2 : bounciness1;
  CGFloat projectedNormalizedSpeed = qcTension;

  // Reverse projection + normalization
  CGFloat bounciness = ((POPBouncy3NormalizationRange * POPBouncy3NormalizationScale) / (POPBouncy3BouncinessNormalizedMax - POPBouncy3BouncinessNormalizedMin)) * (projectedNormalizedBounciness - POPBouncy3BouncinessNormalizedMin);
  CGFloat speed = ((POPBouncy3NormalizationRange * POPBouncy3NormalizationScale) / (POPBouncy3SpeedNormalizedMax - POPBouncy3SpeedNormalizedMin)) * (projectedNormalizedSpeed - POPBouncy3SpeedNormalizedMin);

  // Write back results
  if (outBounciness) {
    *outBounciness = bounciness;
  }

  if (outSpeed) {
    *outSpeed = speed;
  }
}

@end